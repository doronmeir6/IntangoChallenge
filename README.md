# IntangoChallenge
At intango, we need to identify the mobile devices, in order to target them appropriately.
For instance, for a specific campaign, we’d like to target all Samsung Android phones, with a specific screen size.
The features of a mobile device are:
-Smartphone/ Feature phone
-OS - Anrdoid/ iOS
-Tablet/ mobile phone/ smart tv
-Manufacturer - Apple/ Samsung/ LG/ etc.
-Screen size - small, medium, big, XL
-Resolution : 720×1280,750×1334,640×1136,1080×1920,1440×2560 etc.
-Front Camera
-Back Camera
-Gyroscope
We need a class for each concrete device. Each device can have any subset of these features (some of them
or all of them), and any combination of them.
This class will contain a method:
public List<String> getFeatures()
For instance, for Galaxy S10 plus, we will have this class:
GalaxyS10Plus, and its getFeatures method will return
“Mobilephone”, “Android”, “Samsung”, “XL_Screen_Size”, “RES_1440×2560”, “Front Camera”
Please implement a system that supports it, and write a test class for it.
The system should be easily extended, once we add new capabilities (a new resolution or a new
manufacturer), and new features (number of cameras, camera type, supported networks - 3g, 4g, 5g).
