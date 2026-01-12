package com.nexifotech.edumanage.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppColors{
    //Background
    val background: Color
        @Composable get() = if (isSystemInDarkTheme()) BackgroundDark else Background

    val cardBackground: Color
        @Composable get() = if (isSystemInDarkTheme()) CardBackgroundDark else CardBackground

    val textColorPrimary: Color
        @Composable get() = if (isSystemInDarkTheme()) TextColorPrimaryDark else TextColorPrimary

    val textColorSecondary: Color
        @Composable get() = if (isSystemInDarkTheme()) TextColorSecondaryDark else TextColorSecondary

    val primaryColor: Color
        @Composable get() = if (isSystemInDarkTheme()) PrimaryColorDark else PrimaryColor

    val secondary: Color
        @Composable get() = if (isSystemInDarkTheme()) SecondaryColorColorDark else SecondaryColorColor

    val drawerSelectedColor: Color
        @Composable get() = if (isSystemInDarkTheme()) DrawerSelectedColorDark else DrawerSelectedColor

    val borderColor: Color
        @Composable get() = if (isSystemInDarkTheme()) borderColorDark else borderColorLight


    val lightBlue : Color
        @Composable get() = if (isSystemInDarkTheme()) LightBlueDark else LightBlue

    val lightRed : Color
        @Composable get() = if (isSystemInDarkTheme()) LightRedDark else LightRed

    val lightGreen: Color
        @Composable get() = if (isSystemInDarkTheme()) LightGreenDark else LightGreen

    val lightOrange: Color
        @Composable get() = if (isSystemInDarkTheme()) LightOrangeDark else LightOrange

    val lightYellowBackground: Color
        @Composable get() = if (isSystemInDarkTheme()) LightYellowBackgroundDark else LightYellowBackground

    val lightRedBackground: Color
        @Composable get() = if (isSystemInDarkTheme()) LightRedBackgroundDark else LightRedBackground

    val redColor: Color
        @Composable get() = if (isSystemInDarkTheme()) Red else Red

    val greenColor: Color
        @Composable get() = if (isSystemInDarkTheme()) Green else Green

    val orengeColor: Color
        @Composable get() = if (isSystemInDarkTheme()) Orange else Orange

    val blueColor: Color
        @Composable get() = if (isSystemInDarkTheme()) Blue else Blue
}
