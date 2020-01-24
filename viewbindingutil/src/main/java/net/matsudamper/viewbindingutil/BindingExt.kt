package net.matsudamper.viewbindingutil


import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Activity.bindViewBinding(
): Lazy<T> = lazy { ViewBindingUtil.bind<T>(findViewById<ViewGroup>(android.R.id.content)[0]) }

inline fun <reified T : ViewBinding> Fragment.bindViewBinding(
): ReadOnlyProperty<Fragment, T> = CacheViewBindingProvider({ requireView() }, T::class.java)

inline fun <reified T : ViewBinding> Activity.inflateViewBinding(
) = ViewBindingUtil.inflate(layoutInflater, T::class.java)

inline fun <reified T : ViewBinding> Fragment.inflateViewBinding(
) = ViewBindingUtil.inflate(layoutInflater, T::class.java)

class CacheViewBindingProvider<T1, T2 : ViewBinding>(
    private val viewProvider: () -> View,
    private val clazz: Class<T2>
) : ReadOnlyProperty<T1, T2> {

    private var beforeBinding: T2? = null
    private var beforeHashCode: Int? = null

    override operator fun getValue(thisRef: T1, property: KProperty<*>): T2 {
        val view = viewProvider()
        val hashCode = view.hashCode()
        return if (beforeHashCode == null || beforeHashCode != hashCode) {
            beforeHashCode = hashCode

            ViewBindingUtil.bind(view, clazz).also {
                beforeBinding = it
            }
        } else {
            beforeBinding!!
        }
    }
}
