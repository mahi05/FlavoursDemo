<h1>Product Flavors</h1>
<pre><code>
.
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
        </code></pre>

<ul>
<li>
To start with the flavors, we need to declare different flavors at app level build.gradle file inside android block.
	i.e. :-<pre><code>
	productFlavors {
        free {
            applicationId "yourpackagename.free"
        }
        paid {
            applicationId "yourpackagename.paid"
        }
        }
</code>
</pre>
</li>
<li>Typical example: A free and a paid version of the application.</li>
<li>Build Type + Product Flavor = Build Variant</li>
</ul>
