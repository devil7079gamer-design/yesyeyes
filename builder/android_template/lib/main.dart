import 'dart:io';
import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:webview_windows/webview_windows.dart' as win_wv;
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:permission_handler/permission_handler.dart';

final FlutterLocalNotificationsPlugin flutterLocalNotificationsPlugin =
    FlutterLocalNotificationsPlugin();

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  
  // Initialize Notifications
  const AndroidInitializationSettings initializationSettingsAndroid =
      AndroidInitializationSettings('@mipmap/ic_launcher');
      
  const InitializationSettings initializationSettings =
      InitializationSettings(android: initializationSettingsAndroid);
      
  await flutterLocalNotificationsPlugin.initialize(initializationSettings);
  
  // Request Notification Permissions
  await Permission.notification.request();

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    const String targetUrl = String.fromEnvironment('WEB_URL', defaultValue: 'https://google.com');
    const String appTitle = String.fromEnvironment('APP_NAME', defaultValue: 'Vex App');

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: appTitle,
      theme: ThemeData(
        useMaterial3: true,
        colorSchemeSeed: Colors.indigo,
      ),
      home: DynamicWebView(url: targetUrl, title: appTitle),
    );
  }
}

class DynamicWebView extends StatefulWidget {
  final String url;
  final String title;

  const DynamicWebView({super.key, required this.url, required this.title});

  @override
  State<DynamicWebView> createState() => _DynamicWebViewState();
}

class _DynamicWebViewState extends State<DynamicWebView> {
  late final WebViewController _mobileController;
  final _winController = win_wv.WebviewController();
  bool _isWinInitialized = false;
  bool isLoading = true;

  @override
  void initState() {
    super.initState();
    _showWelcomeNotification();

    String formattedUrl = widget.url.trim();
    if (!formattedUrl.startsWith('http://') && !formattedUrl.startsWith('https://')) {
      formattedUrl = 'https://$formattedUrl';
    }

    if (Platform.isWindows) {
      _initWindowsWebView(formattedUrl);
    } else {
      _initMobileWebView(formattedUrl);
    }
  }

  Future<void> _showWelcomeNotification() async {
    const AndroidNotificationDetails androidPlatformChannelSpecifics =
        AndroidNotificationDetails(
      'vex_channel_id',
      'Vex Notifications',
      channelDescription: 'App notification channel',
      importance: Importance.max,
      priority: Priority.high,
      ticker: 'ticker',
    );
    const NotificationDetails platformChannelSpecifics =
        NotificationDetails(android: androidPlatformChannelSpecifics);
        
    await flutterLocalNotificationsPlugin.show(
      0,
      widget.title,
      'App successfully launched and connected!',
      platformChannelSpecifics,
    );
  }

  Future<void> _initWindowsWebView(String url) async {
    try {
      await _winController.initialize();
      await _winController.setBackgroundColor(Colors.white);
      await _winController.loadUrl(url);
      setState(() {
        _isWinInitialized = true;
        isLoading = false;
      });
    } catch (e) {
      setState(() {
        isLoading = false;
      });
    }
  }

  void _initMobileWebView(String url) {
    _mobileController = WebViewController()
      ..setJavaScriptMode(JavaScriptMode.unrestricted)
      ..setNavigationDelegate(
        NavigationDelegate(
          onPageStarted: (_) => setState(() => isLoading = true),
          onPageFinished: (_) => setState(() => isLoading = false),
        ),
      )
      ..loadRequest(Uri.parse(url));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
        backgroundColor: Colors.indigo,
        foregroundColor: Colors.white,
        actions: [
          IconButton(
            icon: const Icon(Icons.refresh),
            onPressed: () {
              if (Platform.isWindows && _isWinInitialized) {
                _winController.reload();
              } else if (!Platform.isWindows) {
                _mobileController.reload();
              }
            },
          ),
        ],
      ),
      body: Stack(
        children: [
          if (Platform.isWindows)
            _isWinInitialized
                ? win_wv.Webview(_winController)
                : const Center(child: Text("Loading Windows WebView..."))
          else
            WebViewWidget(controller: _mobileController),
          
          if (isLoading)
            const Center(
              child: CircularProgressIndicator(),
            ),
        ],
      ),
    );
  }
}
