import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R
import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
//import android.content.res.Configuration
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {

    Spacer(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black))
    Column {
        Image(
            painter = painterResource(R.drawable.main_label2),
            contentDescription = "Game label",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )
        Text(text = "Dota 2 is a multiplayer online battle arena (MOBA) " +
                "game which has two teams of five players compete to " +
                "collectively destroy a large structure defended by " +
                "the opposing team known as the \"Ancient\", whilst" +
                " defending their own.",
            color = MaterialTheme.colors.surface,
            modifier = Modifier.padding(25.dp, 100.dp, 25.dp, 25.dp),
            fontFamily = FontFamily(Font(R.font.bai_jamjuree)),
            fontSize = 12.sp
        )
        LazyRow(userScrollEnabled = true){
            item {
                Image(
                    painter = painterResource(R.drawable.example1),
                    contentDescription = "Example_1",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(125.dp)
                        .width(275.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .padding(horizontal = 25.dp)
                )
            }

            item{
                Image(
                    painter = painterResource(R.drawable.example2),
                    contentDescription = "Example_2",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(125.dp)
                        .width(275.dp)
                        .clip(RoundedCornerShape(25.dp))
                        .padding(horizontal = 25.dp)
                )
            }
        }

        Button(
            onClick = {},
            modifier = Modifier
                .padding(25.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(244, 209, 68))
        ){
            Text("Install", fontSize = 15.sp)
        }
    }

    Column {
        Spacer(modifier = Modifier.height(225.dp))
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Game logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(125.dp)
        )
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Colleague", "Hey,  Compose, it's great!")
    )
}
