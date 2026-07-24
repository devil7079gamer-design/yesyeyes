import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

class WebViewService {
  late final WebViewController controller;

  WebViewController initialize({
    required String url,
    VoidCallback? onPageStarted,
    VoidCallback? onPageFinished,
  }) {
    controller = WebViewController()
      ..setJavaScriptMode(JavaScriptMode.unrestricted)
      ..setBackgroundColor(Colors.white)
      ..enableZoom(true)
      ..setNavigationDelegate(
        NavigationDelegate(
          onPageStarted: (_) {
            if (onPageStarted != null) onPageStarted();
          },
          onPageFinished: (_) {
            if (onPageFinished != null) onPageFinished();
          },
        ),
      )
      ..loadRequest(Uri.parse(url));

    return controller;
  }

  Future<bool> canGoBack() async {
    return await controller.canGoBack();
  }

  Future<void> goBack() async {
    if (await controller.canGoBack()) {
      await controller.goBack();
    }
  }

  Future<void> reload() async {
    await controller.reload();
  }

  Future<void> loadUrl(String url) async {
    await controller.loadRequest(Uri.parse(url));
  }
}