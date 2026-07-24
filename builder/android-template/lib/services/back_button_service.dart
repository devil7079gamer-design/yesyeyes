import 'package:webview_flutter/webview_flutter.dart';

class BackButtonService {
  final WebViewController controller;

  BackButtonService(this.controller);

  Future<bool> onBackPressed() async {
    if (await controller.canGoBack()) {
      await controller.goBack();
      return false;
    }

    return true;
  }

  Future<void> goHome(String url) async {
    await controller.loadRequest(Uri.parse(url));
  }

  Future<void> reload() async {
    await controller.reload();
  }

  Future<bool> canGoBack() async {
    return await controller.canGoBack();
  }
}