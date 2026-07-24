import 'dart:convert';

import '../utils/device_info.dart';
import 'location_service.dart';

class JavaScriptBridge {
  Future<String> getDeviceInfo() async {
    final data = await DeviceInfoHelper.getInfo();
    return jsonEncode(data);
  }

  Future<String> getLocation() async {
    return await LocationService.getLocationString();
  }

  Future<String> getAppVersion() async {
    final data = await DeviceInfoHelper.getInfo();
    return data["version"]?.toString() ?? "";
  }

  Future<String> getPackageName() async {
    final data = await DeviceInfoHelper.getInfo();
    return data["packageName"]?.toString() ?? "";
  }

  Future<String> getAppName() async {
    final data = await DeviceInfoHelper.getInfo();
    return data["appName"]?.toString() ?? "";
  }

  Future<bool> isLocationEnabled() async {
    return await LocationService.requestPermission();
  }
}