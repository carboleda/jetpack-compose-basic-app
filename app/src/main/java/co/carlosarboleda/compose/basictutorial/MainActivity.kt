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
import androidx.ui.res.stringResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewMeetup(meetup = getMeetupData())
        }
    }
}

data class Meetup(
        val title: String,
        val description: String,
        val image: Int,
        val schedule: List<String>
)

@Composable
fun getMeetupData() = Meetup(
        title = stringResource(id = R.string.meetup_title),
        description = stringResource(id = R.string.meetup_description),
        image = R.drawable.android11_meetup_neiva,
        schedule = listOf(
                "08:00 => Bienvenida",
                "08:30 => Introducción a Android",
                "09:30 => Novedades en Android 11",
                "10:30 => Cómo trabajar ordenados con arquitectura MVVM en Android",
                "11:30 => Entendiendo Android Jetpack Compose"
        )
)

@Composable
fun NewMeetup(meetup: Meetup) {
    val typography = MaterialTheme.typography
    MaterialTheme {
        Column(
                modifier = Modifier.padding(16.dp)
        ) {
            MeetupImage(imageId = meetup.image)

            Text(
                    text = meetup.title,
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
            )
            Text(text = meetup.description, style = typography.body2)

            MeetupSchedule(meetup.schedule)
        }
    }
}

@Composable
fun MeetupImage(imageId: Int) {
    Image(
            asset = imageResource(id = imageId),
            modifier = Modifier.preferredHeightIn(maxHeight = 180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
    )
    Spacer(modifier = Modifier.preferredHeight(16.dp))
}

@Composable
fun MeetupSchedule(schedule: List<String>) {
    val typography = MaterialTheme.typography
    Spacer(modifier = Modifier.preferredHeight(16.dp))
    Text(
            text = stringResource(id = R.string.schedule),
            style = typography.h6
    )
    schedule.forEach {
        Text(text = it)
    }
}

@Preview(showDecoration = true)
@Composable
fun DefaultPreview() {
    NewMeetup(meetup = getMeetupData())
}