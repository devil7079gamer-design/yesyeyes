import 'dart:io';

import 'package:permission_handler/permission_handler.dart';

class Permissions {
  Permissions._();

  static Future<bool> requestCamera() async {
    final status = await Permission.camera.request();
    return status.isGranted;
  }

  static Future<bool> requestStorage() async {
    if (!Platform.isAndroid) return true;

    if (await Permission.manageExternalStorage.isGranted) {
      return true;
    }

    final storage = await Permission.storage.request();

    if (storage.isGranted) {
      return true;
    }

    final manage = await Permission.manageExternalStorage.request();
    return manage.isGranted;
  }

  static Future<bool> requestLocation() async {
    final status = await Permission.location.request();
    return status.isGranted;
  }

  static Future<bool> requestMicrophone() async {
    final status = await Permission.microphone.request();
    return status.isGranted;
  }

  static Future<bool> requestNotifications() async {
    final status = await Permission.notification.request();
    return status.isGranted;
  }

  static Future<void> requestAll() async {
    await requestCamera();
    await requestStorage();
    await requestLocation();
    await requestMicrophone();
    await requestNotifications();
  }

  static Future<void> openSettings() async {
    await openAppSettings();
  }
}