package uz.teda.onlineshop.screen.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.teda.onlineshop.R
import uz.teda.onlineshop.api.Api



class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("http://osonsavdo.sd-group.uz/api/")
//            .build()
//        var api = retrofit.create(Api::class.java)

    }

    companion object {

        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}