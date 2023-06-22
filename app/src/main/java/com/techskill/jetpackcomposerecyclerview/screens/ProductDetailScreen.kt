package com.techskill.jetpackcomposerecyclerview.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techskill.jetpackcomposerecyclerview.data.ProductData
import com.techskill.jetpackcomposerecyclerview.data.ProductDetails
import com.techskill.jetpackcomposerecyclerview.ui.theme.JetPackComposeRecyclerViewTheme

@Composable
fun ProductCard(product: ProductDetails) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.Green,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {

        Row(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.weight(1f),
                Arrangement.Center) {
                Text(
                    text = "Product ID:- "+product.productId.toString(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "Product Name:- "+product.productName,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = "Product Type:- "+product.productType,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )

                Text(
                    text = "Product Description :- "+product.productDescription,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
            }
            Image(painter = painterResource(product.productImageId), contentDescription = "Product Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(164.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(1.dp, Color.Gray, CircleShape).background(Color.Green))
        }
    }
}

@Composable
fun DetailsContent() {
    val products = remember { ProductData.ProductDetailsList }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
    ) {
        items(
            products
        ) {
            ProductCard(product = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultProductPreview() {
    JetPackComposeRecyclerViewTheme {
        DetailsContent()
    }
}