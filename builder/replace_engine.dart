import 'dart:io';

class ReplaceEngine {
  static Future<void> replace({
    required Directory project,

    required String appName,
    required String packageName,
    required String websiteUrl,
  }) async {
    await _replaceInDirectory(
      project,
      appName: appName,
      packageName: packageName,
      websiteUrl: websiteUrl,
    );

    await _renamePackageFolders(
      project,
      packageName,
    );
  }

  static Future<void> _replaceInDirectory(
    Directory dir, {
    required String appName,
    required String packageName,
    required String websiteUrl,
  }) async {
    await for (final entity in dir.list(recursive: true)) {
      if (entity is! File) continue;

      final path = entity.path;

      if (!(path.endsWith(".dart") ||
          path.endsWith(".xml") ||
          path.endsWith(".kt") ||
          path.endsWith(".gradle") ||
          path.endsWith(".yaml") ||
          path.endsWith(".properties"))) {
        continue;
      }

      String text = await entity.readAsString();

      text = text.replaceAll("__APP_NAME__", appName);

      text = text.replaceAll("__PACKAGE_NAME__", packageName);

      text = text.replaceAll("__WEBSITE_URL__", websiteUrl);

      await entity.writeAsString(text);
    }
  }

  static Future<void> _renamePackageFolders(
    Directory project,
    String packageName,
  ) async {
    final parts = packageName.split(".");

    final newPath = parts.join(Platform.pathSeparator);

    final oldFolder = Directory(
      "${project.path}/android/app/src/main/kotlin/com/yesyeyes/app",
    );

    if (!await oldFolder.exists()) return;

    final newFolder = Directory(
      "${project.path}/android/app/src/main/kotlin/$newPath",
    );

    await newFolder.create(recursive: true);

    await for (final entity in oldFolder.list()) {
      if (entity is File) {
        await entity.copy(
          "${newFolder.path}/${entity.uri.pathSegments.last}",
        );
      }
    }

    await oldFolder.delete(recursive: true);
  }
}
