import 'dart:io';

import 'package:device_info_plus/device_info_plus.dart';
import 'package:package_info_plus/package_info_plus.dart';

class DeviceInfoHelper {
  static Future<Map<String, dynamic>> getInfo() async {
    final deviceInfo = DeviceInfoPlugin();
    final packageInfo = await PackageInfo.fromPlatform();

    final Map<String, dynamic> data = {
      "appName": packageInfo.appName,
      "packageName": packageInfo.packageName,
      "version": packageInfo.version,
      "buildNumber": packageInfo.buildNumber,
    };

    if (Platform.isAndroid) {
      final android = await deviceInfo.androidInfo;

      data.addAll({
        "brand": android.brand,
        "model": android.model,
        "manufacturer": android.manufacturer,
        "androidVersion": android.version.release,
        "sdkInt": android.version.sdkInt,
        "isPhysicalDevice": android.isPhysicalDevice,
      });
    }

    return data;
  }
}