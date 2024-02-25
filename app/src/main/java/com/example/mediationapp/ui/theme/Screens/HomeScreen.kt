package com.example.mediationapp.ui.theme.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Mediation app Home screen
 */
@Composable
fun HomeScreen(modifier: Modifier =  Modifier){
    Box(
        modifier = Modifier
            .fillMaxSize()
            //.background(color = )
    ){
        Column {
            GreetingsSection()
            ChipsSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression", "All good", "Best in the world"))
            CurrentMediation()
        }
    }
}
@Composable
fun GreetingsSection(
    modifier: Modifier = Modifier,
    name: String = "Phillip"
){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ){
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "Good morning $name")
            Text(text = "Have a good day")
        }
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.Cyan,
            modifier = Modifier.size(24.dp)
        )
    }
}
/**
 * Chips section
 */
@Composable
fun ChipsSection(
    chips: List<String>
){
    var selectedChipsIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(){
        items(chips.size){
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable { selectedChipsIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipsIndex == it) Color.DarkGray
                        else Color.DarkGray
                    )
                    .padding(15.dp)
            ){
                Text(text = chips[it], color = Color.White)
            }
        }
    }

}
/**
 * Current Meditation
 */
@Composable
fun CurrentMediation(
    color: Color = Color.LightGray
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(text = "Mediation . 3-10 mins")
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Cyan)
                .padding(10.dp)
        ) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Play Meditation", modifier = Modifier.size(10.dp))
        }
    }
}
/**
 * Feature section
 */
@Composable
fun FeaturedSection(features: List<Featured>){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.bodyLarge
        )
      LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(
          start = 7.5.dp,
          end = 7.5.dp,
          bottom = 7.5.dp,
      ),
          modifier = Modifier.fillMaxHeight()
      ){
          items(features.size){

          }
      }
    }
}
/**
 * Feature item composable
 */
@Composable
fun FeatureItem(
    featured: Featured
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(featured.darkColor)

    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val  mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            quadraticBezierTo(
                mediumColoredPoint2.x,
                mediumColoredPoint2.y,
                //Describes how the color looks like
                (mediumColoredPoint1.x + mediumColoredPoint2.y)/2
            )

        }

    }
}
/**
 * Feature item composable preview
 */
@Preview(showBackground = true)
@Composable
fun FeatureItemPreview(){
    FeatureItem()
}
/**
 * Featured Section preview
 */
@Preview
@Composable
fun FeaturedSectionPreview(){

}
/**
 * Current mediation Preview
 */
@Preview(showBackground = true)
@Composable
fun CurrentMediationPreview(){
    CurrentMediation()
}
/**
 * Greetings section preview
 */
@Preview(showBackground = true)
@Composable
fun GreetingSectionPreview(){
    GreetingsSection()
}
/**
 * Chips Section Preview
 */
@Preview(showBackground = true)
@Composable
fun ChipsSectionPreview(){
    //  ChipsSection()
}

/**
 * Home Screen Preview
 */
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}

