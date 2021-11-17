package uz.teda.onlineshop.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import uz.teda.onlineshop.R
import uz.teda.onlineshop.screen.cart.CartFragment
import uz.teda.onlineshop.screen.favotire.FavoriteFragment
import uz.teda.onlineshop.screen.home.HomeFragment
import uz.teda.onlineshop.screen.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    val homeFragment = HomeFragment.newInstance()
    val cartFragment = CartFragment.newInstance()
    val favoriteFragment = FavoriteFragment.newInstance()
    val profileFragment = ProfileFragment.newInstance()
    var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, homeFragment, homeFragment.tag).hide(homeFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, cartFragment, cartFragment.tag).hide(cartFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, favoriteFragment, favoriteFragment.tag).hide(favoriteFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, profileFragment, profileFragment.tag).hide(profileFragment)
            .commit()

        supportFragmentManager.beginTransaction().show(activeFragment).commit()


        buttonNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.actionHome -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
                    activeFragment = homeFragment
                }
                R.id.actionProfile -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit()
                    activeFragment = profileFragment
                }
                R.id.actionFavorite -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(favoriteFragment).commit()
                    activeFragment = favoriteFragment
                }
                R.id.actionBasket -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(cartFragment).commit()
                    activeFragment = cartFragment
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}


