class AppSettings {
  final String appName;
  final String websiteUrl;
  final String packageName;

  final bool enableJavaScript;
  final bool enablePullRefresh;
  final bool enableDownloads;
  final bool enableFileUpload;
  final bool enableLocation;
  final bool enableCamera;

  const AppSettings({
    required this.appName,
    required this.websiteUrl,
    required this.packageName,
    required this.enableJavaScript,
    required this.enablePullRefresh,
    required this.enableDownloads,
    required this.enableFileUpload,
    required this.enableLocation,
    required this.enableCamera,
  });

  factory AppSettings.defaultSettings() {
    return const AppSettings(
      appName: "Website To App",
      websiteUrl: "__WEBSITE_URL__",
      packageName: "__PACKAGE_NAME__",
      enableJavaScript: true,
      enablePullRefresh: true,
      enableDownloads: true,
      enableFileUpload: true,
      enableLocation: true,
      enableCamera: true,
    );
  }
}