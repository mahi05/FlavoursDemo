<h1>Product Flavors</h1>

`.
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
└── src
    ├── free
    │   └── java                        <--- Source code for "free" product flavor
    ├── main
    │   ├── AndroidManifest.xml
    │   ├── java
    │   └── res
    └── pro
        └── java                        <--- Source code for "pro" product flavor
`

<ul>
<li>A product flavor defines a customized version of the application build by the project.</li>
<li>Typical example: A free and a paid version of the application.</li>
<li>Build Type + Product Flavor = Build Variant</li>
</ul>
