import 'package:flutter/material.dart';

import 'screens/webview_screen.dart';

class WebsiteToApp extends StatelessWidget {
  const WebsiteToApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Website To App',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        useMaterial3: true,
        colorSchemeSeed: Colors.blue,
      ),
      home: const WebViewScreen(),
    );
  }
}