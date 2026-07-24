import 'package:flutter/material.dart';

class WebsiteErrorWidget extends StatelessWidget {
  final VoidCallback onRetry;

  const WebsiteErrorWidget({
    super.key,
    required this.onRetry,
  });

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Icon(
              Icons.wifi_off,
              size: 70,
              color: Colors.red,
            ),
            const SizedBox(height: 20),
            const Text(
              "Unable to connect",
              style: TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 10),
            const Text(
              "Please check your internet connection and try again.",
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 25),
            ElevatedButton.icon(
              onPressed: onRetry,
              icon: const Icon(Icons.refresh),
              label: const Text("Retry"),
            ),
          ],
        ),
      ),
    );
  }
}