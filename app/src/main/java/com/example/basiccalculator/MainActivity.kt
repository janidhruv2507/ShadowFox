package com.example.basiccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {
       private lateinit var expression: TextView
       private  lateinit var result: TextView
       private  lateinit var clear : Button
       private lateinit var backspace: Button
       private lateinit var percent:Button
       private lateinit var divide:Button
       private lateinit var multiply:Button
       private lateinit var add:Button
       private lateinit var substract:Button
       private lateinit var equal:Button
       private lateinit var dot: Button
       private lateinit var zero: Button
       private lateinit var doublezero: Button
       private lateinit var one: Button
       private lateinit var two: Button
       private lateinit var three: Button
       private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expression = findViewById(R.id.operationTextView)
        result= findViewById(R.id.resultTextView)
        clear= findViewById(R.id.buttonClear)
        backspace= findViewById(R.id.buttonbackspace)
        percent = findViewById(R.id.buttonPercent)
        divide= findViewById(R.id.buttonDivide)
        multiply= findViewById(R.id.buttonMultiply)
        substract= findViewById(R.id.buttonSubtract)
        add= findViewById(R.id.buttonAdd)
        equal = findViewById(R.id.buttonEquals)
        dot= findViewById(R.id.buttonDot)
        zero= findViewById(R.id.button0)
        doublezero= findViewById(R.id.buttonDoubleZero)
        one= findViewById(R.id.button1)
        two= findViewById(R.id.button2)
        three= findViewById(R.id.button3)
        four= findViewById(R.id.button4)
        five= findViewById(R.id.button5)
        six= findViewById(R.id.button6)
        seven= findViewById(R.id.button7)
        eight= findViewById(R.id.button8)
        nine= findViewById(R.id.button9)


        expression.movementMethod = ScrollingMovementMethod()
        expression.isActivated = true
        expression.isPressed = true

        var str: String

        clear.setOnClickListener {
            expressionText("0")
            expression.textSize = 60F
            result.textSize = 30F
            resultText()
        }
        backspace.setOnClickListener {
            if (expression.text.toString().isNotEmpty()){
                val lastIndex = expression.text.toString().lastIndex
                str = expression.text.toString().substring(0 ,lastIndex)
                expressionText(str)
                resultText()
            }
        }
        percent.setOnClickListener {
            if (expression.text.toString().endsWith("%") || expression.text.toString().endsWith("/") || expression.text.toString().endsWith("*") ||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str =expression.text.toString()
            }
            else{
                str = expression.text.toString() +"%"
                expressionText(str)
            }

        }
        divide.setOnClickListener {
            if (expression.text.toString().endsWith("%") || expression.text.toString().endsWith("/") || expression.text.toString().endsWith("*") ||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str =expression.text.toString()
            }
            else{
                str = expression.text.toString() +"/ "
                expressionText(str)
            }

        }
        multiply.setOnClickListener {
            if (expression.text.toString().endsWith("%") || expression.text.toString().endsWith("/") || expression.text.toString().endsWith("*") ||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str =expression.text.toString()
            }
            else{
                str = expression.text.toString() +"*"
                expressionText(str)
            }

        }
        add.setOnClickListener {
            if (expression.text.toString().endsWith("%") || expression.text.toString().endsWith("/") || expression.text.toString().endsWith("*") ||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str =expression.text.toString()
            }
            else{
                str = expression.text.toString() +"+"
                expressionText(str)
            }

        }
        substract.setOnClickListener {
            if (expression.text.toString().endsWith("%") || expression.text.toString().endsWith("/") || expression.text.toString().endsWith("*") ||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str =expression.text.toString()
            }
            else{
                str = expression.text.toString() +"-"
                expressionText(str)
            }

        }
        equal.setOnClickListener {
            expression.textSize=30F
            result.textSize =60F


        }
        dot.setOnClickListener {
            if (expression.text.toString().endsWith("%") || expression.text.toString().endsWith("/") || expression.text.toString().endsWith("*") ||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str =expression.text.toString()
            }
            else{
                str = expression.text.toString() +"."
                expressionText(str)
            }

        }
        zero.setOnClickListener {
             if (expression.text.toString().startsWith("0 ")){
                 str=expression.text.toString().replace("0", "") +"0"
                 expressionText(str)
             }else{
                 str =expression.text.toString() +"0"
                 expressionText(str)
                 resultText()
             }

        }
        doublezero.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"00"
                expressionText(str)
            }else{
                str =expression.text.toString() +"00"
                expressionText(str)
                resultText()
            }

        }
        one.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"1"
                expressionText(str)
            }else{
                str =expression.text.toString() +"1"
                expressionText(str)
                resultText()
            }

        }
        two.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"2"
                expressionText(str)
            }else{
                str =expression.text.toString() +"2"
                expressionText(str)
                resultText()
            }
        }
        three.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"3"
                expressionText(str)
            }else{
                str =expression.text.toString() +"3"
                expressionText(str)
                resultText()
            }

        }
        four.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"4"
                expressionText(str)
            }else{
                str =expression.text.toString() +"4"
                expressionText(str)
                resultText()
            }

        }
        five.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"5"
                expressionText(str)
            }else{
                str =expression.text.toString() +"5"
                expressionText(str)
                resultText()
            }

        }
        six.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"6"
                expressionText(str)
            }else{
                str =expression.text.toString() +"6"
                expressionText(str)
                resultText()
            }

        }
        seven.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"7"
                expressionText(str)
            }else{
                str =expression.text.toString() +"7"
                expressionText(str)
                resultText()
            }

        }
        eight.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"8"
                expressionText(str)
            }else{
                str =expression.text.toString() +"8"
                expressionText(str)
                resultText()
            }


        }
        nine.setOnClickListener {
            if (expression.text.toString().startsWith("0 ")){
                str=expression.text.toString().replace("0", "") +"9"
                expressionText(str)
            }else{
                str =expression.text.toString() +"9"
                expressionText(str)
                resultText()
            }

        }

    }
    private fun expressionText(str:String){
         expression.text = str
    }
    private fun resultText(){
        val exp = expression.text.toString()
        val engine:ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try
        {
            val res = engine.eval(exp)
            if (res.toString().endsWith(".0"))
            {
                result.text = "=" + res.toString().replace(".0"," ")
            }
            else
            {
                result.text = "=$res"
            }
        }catch (e:Exception){
            expression.text =expression.text.toString()
            result.text = expression.text.toString()
        }
    }
}
