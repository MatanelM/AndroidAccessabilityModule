# AndroidAccessabilityModule
Android library that offers accessible UI components with adjustable text sizes for enhanced readability in Android applications.

## Installation

To use this library in your Android project, follow these steps:

1. Download textaccessability project from the latest releases
2. Import the module to your android project
3. Implement in the application by writing the following code in your app build.gradle file
```
dependencies {
    implementation project(':textaccessability')

    ...
}
```
4. Add the following action to the event of the accessability text button

```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        Button bigButton = view.findViewById(R.id.big_button);
        bigButton.setOnClickListener(v -> updateAll(v, 1)); // 1 is for medium size.
    }
 
```
5. pick size 0, 1 or 2.


## Example

https://github.com/MatanelM/AndroidAccessabilityModule/assets/33670032/72039d42-c1e9-4b10-aed0-bf21ac7465b1

