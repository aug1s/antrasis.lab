package com.example.augis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.augis.options

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonas:Button=findViewById(R.id.spausd)
        val ivedimas:EditText=findViewById(R.id.txt)
        val Spinner:Spinner=findViewById(R.id.pas_spin)
        val text:TextView=findViewById(R.id.info_txt)

        //  @Override
        // protected void onCreate(Bundle savedInstanceState) {
        //    super.onCreate(savedInstanceState);
        //    setContentView(R.layout.activity_main);
        //
        //     this.ddSelection = (Spinner) findViewById(R.id.ddSelection);
        //    ArrayList<String> selectionOptionsList = new ArrayList<>();
        //    selectionOptionsList.add("Words");
        //    selectionOptionsList.add("Chars");
        //    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, selectionOptionsList);
        //    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //    this.ddSelection.setAdapter(arrayAdapter);
        //}

        ArrayAdapter.createFromResource(
            this, R.array.pasirinkimai, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            Spinner.adapter = adapter
        }
        buttonas.setOnClickListener() {
            val notCounted: String = ivedimas.text.toString();
            val pas2: String = Spinner.selectedItem.toString();
            val pas3 = options.Pasirinkimai(pas2,notCounted);
            val rezultatas : String = options.Pasirinkimai(pas2,notCounted).toString();
            if (rezultatas != "0") {text.text = rezultatas}
            else {
                text.text = ""
                Toast.makeText(this@MainActivity, "Insert Text", Toast.LENGTH_SHORT).show()
                //public void btnCalculateOnClick(View view) {
                //    EditText edUserInput = findViewById(R.id.edUserInput);
                //    TextView tvOutput = findViewById(R.id.tvOutput);
                //    String userInputText = edUserInput.getText().toString();

                //    String selection = this.ddSelection.getSelectedItem().toString();
                //   if(selection.equalsIgnoreCase("Chars")){
                //        int count = getCharsCount(userInputText);
                //        tvOutput.setText(String.valueOf(count));
            }

        }

    }
}