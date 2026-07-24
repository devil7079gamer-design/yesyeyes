import 'package:flutter/material.dart';

class OfflineWidget extends StatelessWidget {
  final VoidCallback onRetry;

  const OfflineWidget({
    super.key,
    required this.onRetry,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Center(
          child: Padding(
            padding: const EdgeInsets.all(24),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const Icon(
                  Icons.wifi_off_rounded,
                  size: 90,
                  color: Colors.red,
                ),
                const SizedBox(height: 20),
                const Text(
                  "No Internet Connection",
                  style: TextStyle(
                    fontSize: 24,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                const SizedBox(height: 12),
                const Text(
                  "Please check your internet connection and try again.",
                  textAlign: TextAlign.center,
                  style: TextStyle(fontSize: 16),
                ),
                const SizedBox(height: 30),
                SizedBox(
                  width: double.infinity,
                  child: ElevatedButton.icon(
                    onPressed: onRetry,
                    icon: const Icon(Icons.refresh),
                    label: const Text("Retry"),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}