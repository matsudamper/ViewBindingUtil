# ViewBindingUtil
[![](https://jitpack.io/v/matsudamper/ViewBindingUtil.svg)](https://jitpack.io/#matsudamper/ViewBindingUtil)

# Usage
## gradle
```groovy
repositories {
  maven { url 'https://jitpack.io' }
}
dependencies {
  implementation 'com.github.matsudamper:ViewBindingUtil:${version}'
}
```

## Sample
https://github.com/matsudamper/ViewBindingUtil/tree/master/app/src/main/java/net/matsudamper/viewbindingutil

- Basic Usage
```kotlin
val binding = ViewBindingUtil.inflate<ActivityMainBinding>(layoutInflater)

val view = layoutInflater.inflate(R.layout.activity_main, null)
val binding = ViewBindingUtil.bind<ActivityMainBinding>(view)
```

- Activity or Fragment delegation
```kotlin
binding : HogeBinding = inflateViewBinding()
```

- AndroidX Activity and Fragment delegation
```kotlin
class SampleActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by bindViewBinding<ActivityMainBinding>()
}

class BindSampleFragment : Fragment(R.layout.fragment_main) {
    // Considering the reproducibility of the view
    private val binding by bindViewBinding<FragmentMainBinding>()
}
```
