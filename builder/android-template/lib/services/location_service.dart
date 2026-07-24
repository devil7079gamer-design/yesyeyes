import 'package:geolocator/geolocator.dart';

class LocationService {
  static Future<bool> requestPermission() async {
    bool serviceEnabled = await Geolocator.isLocationServiceEnabled();

    if (!serviceEnabled) {
      return false;
    }

    LocationPermission permission =
        await Geolocator.checkPermission();

    if (permission == LocationPermission.denied) {
      permission = await Geolocator.requestPermission();
    }

    if (permission == LocationPermission.denied) {
      return false;
    }

    if (permission == LocationPermission.deniedForever) {
      return false;
    }

    return true;
  }

  static Future<Position?> getCurrentLocation() async {
    if (!await requestPermission()) {
      return null;
    }

    return await Geolocator.getCurrentPosition(
      desiredAccuracy: LocationAccuracy.high,
    );
  }

  static Future<String> getLocationString() async {
    final position = await getCurrentLocation();

    if (position == null) {
      return "";
    }

    return "${position.latitude},${position.longitude}";
  }
}