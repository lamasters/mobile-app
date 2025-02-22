package io.rebble.cobble.shared.ui.view.home.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.rebble.cobble.shared.ui.AppTheme
import io.rebble.cobble.shared.ui.common.RebbleIcons
import io.rebble.cobble.shared.ui.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(viewModel: SettingsViewModel = viewModel { SettingsViewModel() }) {
    Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                        title = {
                            Text(
                                    "Settings",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                            )
                        },
                )
            },
    ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding).verticalScroll(rememberScrollState())) {
            Card(colors = CardDefaults.cardColors(containerColor = AppTheme.materialColors.surface), modifier = Modifier.padding(8.dp)) {
                Column {
                    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.width(50.dp).height(50.dp).clip(CircleShape).background(AppTheme.materialColors.primary))
                        Column(modifier = Modifier.offset(x = 10.dp)) {
                            Text("Rebble Account", fontWeight = FontWeight.Bold)
                            Text("Account Holder Name")
                        }
                    }
                    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        RebbleIcons.dictationMicrophone()
                        Column(modifier = Modifier.offset(x = 10.dp)) {
                            Text("Voice and Weather Subscription", fontWeight = FontWeight.Bold)
                            Text("Not subscribed")
                        }
                    }
                    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        RebbleIcons.timelinePin()
                        Column(modifier = Modifier.offset(x = 10.dp)) {
                            Text("Timeline Sync", fontWeight = FontWeight.Bold)
                            Text("Every 3 hours")
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp), horizontalArrangement = Arrangement.End) {
                        TextButton(onClick = {}, modifier = Modifier.padding(horizontal = 4.dp)) {
                            Text("Sign out")
                        }
                        TextButton(onClick = {}, modifier = Modifier.padding(horizontal = 4.dp)) {
                            Text("Manage Account")
                        }
                    }
                }
            }
            ListItem(
                    headlineContent = { Text("Notifications and Muting") },
                    leadingContent = { RebbleIcons.notification() },
                    trailingContent = { RebbleIcons.caretRight() },
                    modifier = Modifier.clickable { }
            )
            ListItem(
                    headlineContent = { Text("Health") },
                    leadingContent = { RebbleIcons.healthHeart() },
                    trailingContent = { RebbleIcons.caretRight() },
                    modifier = Modifier.clickable { }
            )
            ListItem(
                    headlineContent = { Text("Calendar") },
                    leadingContent = { RebbleIcons.calendar() },
                    trailingContent = { RebbleIcons.caretRight() },
                    modifier = Modifier.clickable { }
            )
            ListItem(
                    headlineContent = { Text("About and Support") },
                    leadingContent = { RebbleIcons.aboutApp() },
                    trailingContent = { RebbleIcons.caretRight() },
                    modifier = Modifier.clickable { }
            )
            ListItem(
                    headlineContent = { Text("Developer Options") },
                    leadingContent = { RebbleIcons.developerSettings() },
                    trailingContent = { RebbleIcons.caretRight() },
                    modifier = Modifier.clickable { }
            )
            ListItem(
                    headlineContent = { Text("Widget Library") },
                    leadingContent = { RebbleIcons.healthHeart() },
                    trailingContent = { RebbleIcons.caretRight() },
                    modifier = Modifier.clickable { }
            )
        }
    }
}
