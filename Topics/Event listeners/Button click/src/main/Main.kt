class MainActivity : AppCompatActivity() {
    // Do not change the line below!
    lateinit var searchBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBtn = findViewById(R.id.search_btn)
        // Write your code here
        searchBtn.setOnClickListener { performSearch() }
    }
}

//Button click
//
//Finish implementing the MainActivity class so that the performSearch() function is called when the searchBtn is clicked.
//
//performSearch() is accessible in the current scope.