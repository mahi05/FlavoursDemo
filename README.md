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
<li>Now go to src directory of the project and create folders with the name of flavors. i.e. free, paid.</li>
<li>Create folders with the names of java and res inside newly created flavor folders.</li>
<li>Add package with the same package name of project inside java directory of both flavors.</li>
<li>Create a java class with the name of "Constants.java" in both flavors.</li>
<li>Add a static string with the different url of different flavors.
	i.e. :-
		1.	http://www.example.com/FreeApi
		2.	http://www.example.com/PaidApi</li>
</ul>
