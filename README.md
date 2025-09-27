# AND101 Project 4 - CodeMath

Submitted by: **Carlos Hernandez**

Time spent: **11.5** hours spent in total

## Summary

**CodeMath — Tip & Split** is an Android utility app that helps calculate tips, totals, and per-person bill splits.  
The user enters a bill amount, chooses a tip percentage, and can optionally specify how many people are splitting the bill.  
The app instantly shows the tip, total, and per-person cost, with options to round the tip or total to the nearest whole dollar.  
A clear button lets you reset the form with one tap.

If I had to describe this project in three (3) emojis, they would be: **🧮💸✨**

## Application Features

The following REQUIRED features are completed:

- [x] At least one (1) user input (EditText + Spinner)
- [x] At least one (1) interactive View (Button, RadioGroup, Spinner)
- [x] At least one (1) output of a calculation based on the user input (TextViews update in real-time)

The following STRETCH features are implemented:

- [x] Implement ViewBinding to reduce boilerplate code and increase efficiency
- [x] Add at least one (1) additional functionality (number of people field, rounding options)

The following EXTRA features are implemented:

- [x] Auto-update of results as the user types (no "Calculate" button required)
- [x] Clear button resets all fields back to defaults

## Video Demo

Here's a video / GIF that demos all of the app's implemented features:

![Kapture 2025-09-26 at 19.57.10.gif](../../../../private/var/folders/9z/fmfxrqb52wd_dgdbd_bqj2880000gn/T/43912492afe523c2e5c4c4289d44a50f/Kapture%202025-09-26%20at%2019.57.10.gif)

GIF created with **Kap** (macOS)

## Notes

I learned how to use **ViewBinding** instead of `findViewById`, which made the code much cleaner and less error-prone.  
I also practiced working with **TextWatchers** and **RadioGroups** to update calculations dynamically.  
The biggest challenge was configuring Gradle correctly to support the latest Android Studio setup.

## License

Copyright **2025** **Carlos Hernandez**

Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License.
