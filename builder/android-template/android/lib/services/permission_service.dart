import 'dart:io';

import 'package:permission_handler/permission_handler.dart';

class PermissionService {
  static Future<void> requestAll() async {
    await Permission.notification.request();

    await Permission.camera.request();

    await Permission.photos.request();

    await Permission.location.request();

    await Permission.microphone.request();

    if (Platform.isAndroid) {
      await Permission.storage.request();

      await Permission.manageExternalStorage.request();
    }
  }

  static Future<bool> hasLocationPermission() async {
    return await Permission.location.isGranted;
  }

  static Future<bool> hasCameraPermission() async {
    return await Permission.camera.isGranted;
  }

  static Future<bool> hasStoragePermission() async {
    if (Platform.isAndroid) {
      return await Permission.manageExternalStorage.isGranted ||
          await Permission.storage.isGranted;
    }

    return true;
  }

  static Future<void> openSettings() async {
    await openAppSettings();
  }
}