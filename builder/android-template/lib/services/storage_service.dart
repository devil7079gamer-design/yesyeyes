import 'dart:io';

import 'package:path_provider/path_provider.dart';

class StorageService {
  static Future<Directory> getAppDirectory() async {
    return await getApplicationDocumentsDirectory();
  }

  static Future<Directory> getCacheDirectory() async {
    return await getTemporaryDirectory();
  }

  static Future<File> createFile(
    String fileName,
    String content,
  ) async {
    final dir = await getAppDirectory();

    final file = File("${dir.path}/$fileName");

    return await file.writeAsString(content);
  }

  static Future<String?> readFile(
    String fileName,
  ) async {
    try {
      final dir = await getAppDirectory();

      final file = File("${dir.path}/$fileName");

      if (!await file.exists()) {
        return null;
      }

      return await file.readAsString();
    } catch (_) {
      return null;
    }
  }

  static Future<void> deleteFile(
    String fileName,
  ) async {
    try {
      final dir = await getAppDirectory();

      final file = File("${dir.path}/$fileName");

      if (await file.exists()) {
        await file.delete();
      }
    } catch (_) {}
  }

  static Future<bool> fileExists(
    String fileName,
  ) async {
    final dir = await getAppDirectory();

    return File("${dir.path}/$fileName").exists();
  }

  static Future<int> fileSize(
    String fileName,
  ) async {
    final dir = await getAppDirectory();

    final file = File("${dir.path}/$fileName");

    if (!await file.exists()) {
      return 0;
    }

    return await file.length();
  }
}