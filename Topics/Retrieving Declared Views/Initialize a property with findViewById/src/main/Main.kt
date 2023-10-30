class MainActivity : FakeActivity() {
    var userNameTextView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userNameTextView = findViewById(R.id.userNameTextView)
    }
}

//You have declared a layout activity_main.xml that contains a T
//extView with an ID of userNameTextView. Declare a field
//named userNameTextView and initialize it with the view just mentioned.
//Note that the provided code is a fake – it is not an actual
//Android code. It is only provided for completing the task,
//there are no Android dependencies available.
