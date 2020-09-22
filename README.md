
Introduction
-------
BetterPath is a fork of the Hopscotch library, which brings a pure JVM implementation of the android.graphics.Path class, instead of relying on the SKIA library supplied by the Android Framework at runtime (and therefore only available on certain API levels).
BetterPath improves upon Hopscotch by adding operations export and import functionality to the BetterPath class.

Features
-------
+ Operations Import and Export
+ Implements Serializable
+ Implements Parcelable
+ Save Paths to storage for later

Usage
-------
Wherever you would normally use `Path`, just use `BetterPath` instead. Feel free to pass it
around in Intents or Bundles or write it out to disk. And when you actually need an instance of
`Path`, call the `makePath()` method and it will build you one. BetterPath also supports export and import
of the operations list that act as an instruction set for creating the Path.

```java
public class FirstActivity extends Activity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        BetterPath path = new BetterPath();

        Intent intent = new Intent(this, SecondActivity.class);
        //Since BetterPath implements both Parcelable and Serializable,
        //    we need to specify
        intent.putExtra("path", (Parcelable) path);
        startActivity(intent);
    }
}


public class SecondActivity extends Activity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        BetterPath path = getIntent().getParcelableExtra("path");
        Path realPath = path.makePath();
    }
}
```

Documentation
-------

Dependencies
-----
BetterPath is on Maven Central! Simply add the following line into your build.gradle file. Remember to update the version number properly.
```
    compile 'com.tylereastman.library:betterpath:X.X.X'
```

FAQ
-------
> Why BetterPath?

BetterPath is forked from Hopscotch. The way that Hopscotch works is basically recording every move that extends the path. Each step is discrete and iterable, much like a hopscotch court.


![Hopscotch](https://github.com/myriadmobile/hopscotch/raw/master/res/hopscotch.png)

License
-------

The MIT License (MIT)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
