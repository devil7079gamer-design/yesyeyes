# Website To APK Builder
## Final Folder Structure


builder/

│
├── engine/
│   └── replace_engine.py
│
├── templates/
│   └── android-project/
│       ├── app/
│       ├── gradle/
│       ├── build.gradle
│       └── settings.gradle
│
├── input/
│   ├── config.json
│   └── icon.png
│
├── output/
│   └── generated-app/
│
├── build/
│   └── apk/
│       └── final.apk
│
├── scripts/
│   └── build_apk.py
│
├── logs/
│   └── builder.log
│
└── README.md



# Builder Flow


User Input
    |
    ↓
config.json
    |
    ↓
replace_engine.py
    |
    ↓
Android Template Copy
    |
    ↓
Replace App Data
    |
    ↓
Gradle Build
    |
    ↓
APK Output



# Testing Checklist


## 1. Replace Engine Test

Run:

python engine/replace_engine.py


Check:

✓ App name changed

✓ Website URL changed

✓ Package name changed

✓ Icon replaced



## 2. Android Build Test


Open generated app:


cd output/generated-app


Run:

gradlew assembleRelease



Check:

✓ Build successful

✓ APK generated



## 3. Install Test


Install APK on Android phone.


Check:


✓ App opens

✓ Website loads

✓ Icon appears

✓ App name correct



## 4. Final Output


Generated APK location:


build/apk/final.apk
