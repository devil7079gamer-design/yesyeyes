import 'package:connectivity_plus/connectivity_plus.dart';

class ConnectivityService {
  static final Connectivity _connectivity = Connectivity();

  static Future<bool> hasInternet() async {
    final result = await _connectivity.checkConnectivity();

    if (result is List<ConnectivityResult>) {
      return !result.contains(ConnectivityResult.none);
    }

    return result != ConnectivityResult.none;
  }

  static Stream<List<ConnectivityResult>> onChanged() {
    return _connectivity.onConnectivityChanged;
  }
}