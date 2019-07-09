# Windows Wallpaper

## Introduction
Windows utility which allows you to add wallpapers from lock screen to your desktop background.

## Usage

```kotlin
// change path from kosty to your user
const val DEFAULT_WALLPAPER_FOLDER_PATH = "C:\\Users\\kosty\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets"

// change path to your folder where you want to keep wallpapers
const val DESTINATION_FOLDER_WITH_WALLPAPERS = "F:\\Image\\тема\\wallpaper"
```

## How to do
### 1st way
- ```mvn clean install```
- Go to ```WindowsWallpaper/target/```

### 1st way (it doesn't work always in my case)
- Create shortcut of ```windows-wallpaper-0.0.1-jar-with-dependencies.jar```
- Press ```Win + R```
- Enter ```shell:startup```
- Copy shortcut to the startup folder
- ??
- PROFIT

### 2nd way
- You can create a task in [Task Scheduler](https://www.thewindowsclub.com/how-to-schedule-batch-file-run-automatically-windows-7)

### Congratulation! Wallpapers from lock screen will be coping to your folder when you startup Windows

