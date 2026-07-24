import 'package:flutter/material.dart';

import 'screens/splash_screen.dart';
import 'utils/app_theme.dart';

class WebsiteToApp extends StatelessWidget {
  const WebsiteToApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Website Builder',
      debugShowCheckedModeBanner: false,

      theme: AppTheme.lightTheme,

      home: const SplashScreen(),
    );
  }
}