package co.carlosarboleda.compose.basictutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import co.carlosarboleda.compose.basictutorial.ui.ComposeBasicTutorialTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory()
        }
    }
}

@Composable
fun NewStory() {
    val image = imageResource(id = R.drawable.header)
    val typography = MaterialTheme.typography
    MaterialTheme {
        Column(
                modifier = Modifier.padding(16.dp)
        ) {
            Image(
                    asset = image,
                    modifier = Modifier.preferredHeightIn(maxHeight = 180.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Text(
                    text = "A day wandering through the sandhills in Shark Fin Cove," +
                            "and a few of the sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
            )
            Text(text = "Davenport, California", style = typography.body2)
            Text(text = "July 2020", style = typography.body2)
        }
    }
}

@Preview(showDecoration = true)
@Composable
fun DefaultPreview() {
    NewStory()
}