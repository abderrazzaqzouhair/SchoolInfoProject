package com.example.cmcinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cmcinfo.ui.theme.CmcInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CmcInfoTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun Hello(isScreen: MutableState<Boolean>) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = R.string.Bienvenue))
        OutlinedButton(onClick = { isScreen.value = false}) {
            Text(text = stringResource(id = R.string.contenue),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = Bold,
                    fontSize = 19.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )
            
        }
    }
}
@Composable
fun Topbare(isScreen: MutableState<Boolean>){
    Row (modifier = Modifier
        .fillMaxWidth()
        .background(colorResource(id = R.color.teal_700))
        .padding(top = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        IconButton(onClick = {isScreen.value = true}) {
            Text(
                text = "⬅\uFE0F",
                modifier = Modifier.padding(start = 2.dp)
            )
            
        }
        Text(text = stringResource(id = R.string.title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        IconButton(onClick = { /*TODO*/ }) {
            Text(text = "⚙\uFE0F")
            
        }
    }

}
@Composable
fun Info(qoution:String, anser:String) {
    var ispadding = remember {
        mutableStateOf(false)
    }
    var an = if(ispadding.value){
        anser
    } else{
        ""
    }
    Column(modifier = Modifier.padding(horizontal = 0.dp, vertical = 3.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.teal_200)),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = qoution,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Button(onClick = {ispadding.value = !ispadding.value }) {
                Text(text = if(ispadding.value) "afficher moins" else "afficher plus")
            }

        }
        Row (modifier = Modifier.background(colorResource(id = R.color.teal_200))){
            Text(
                modifier = Modifier.weight(1f),
                text = an
            )


        }
    }
}
var infoList = listOf(
    listOf("Quel est le programme de CMC ?", "CMC adopte un programme \"apprendre en faisant\", qui met l'accent sur l'apprentissage expérientiel. Cette approche permet aux élèves de s'engager directement avec le matériel à travers des projets pratiques, des applications réelles et des activités interactives, favorisant une compréhension approfondie des concepts et améliorant leurs compétences en résolution de problèmes."),
    listOf("Quelles classes CMC dessert-elle ?", "CMC dessert trois niveaux éducatifs principaux : qualifiant, technicien et technicien spécialisé. Cette structure garantit que les élèves reçoivent une éducation adaptée à leurs aspirations académiques et professionnelles, permettant une formation spécialisée dans divers domaines."),
    listOf("Quelles sont les heures d'ouverture de CMC ?", "CMC fonctionne de 8h30 à 18h30. Ce calendrier offre un environnement d'apprentissage complet où les élèves peuvent participer à des cours académiques, des activités parascolaires et des programmes de développement personnel tout au long de la journée."),
    listOf("Quelles activités parascolaires sont disponibles à CMC ?", "CMC propose une gamme d'activités parascolaires conçues pour enrichir l'expérience éducative des élèves. Celles-ci incluent un espace de coworking pour des projets collaboratifs, une bibliothèque bien fournie pour la recherche et la lecture, ainsi que des activités de jeu qui favorisent le travail d'équipe et la réflexion stratégique, permettant aux élèves d'explorer leurs intérêts au-delà de la salle de classe."),
    listOf("Comment CMC gère-t-elle la discipline et la gestion du comportement ?", "La discipline à CMC est appliquée avec rigueur pour maintenir un environnement d'apprentissage propice. CMC met l'accent sur le respect, la responsabilité et la responsabilité parmi les élèves, garantissant que le comportement est en adéquation avec les valeurs de l'école. Des directives claires et des conséquences sont communiquées pour favoriser une atmosphère positive."),
    listOf("Quelles sont les qualifications des enseignants à CMC ?", "Tous les enseignants de CMC sont hautement qualifiés et possèdent les diplômes nécessaires ainsi que l'expérience dans leurs domaines respectifs. Cela inclut une formation spécialisée dans leurs matières, garantissant qu'ils peuvent fournir un enseignement expert et du mentorat à leurs élèves. CMC privilégie le développement professionnel continu de ses éducateurs pour rester à jour avec les tendances et méthodologies éducatives."),
    listOf("Comment CMC soutient-elle les élèves ayant des besoins spéciaux ?", "CMC s'engage en faveur de l'inclusion et fournit divers services de soutien aux élèves ayant des besoins spéciaux. Cela inclut des plans éducatifs personnalisés, l'accès à des ressources spécialisées et la présence d'un psychiatre pour traiter la santé mentale et le bien-être émotionnel, garantissant que chaque élève reçoit le soutien dont il a besoin pour s'épanouir."),
    listOf("Quelles ressources technologiques sont disponibles pour les élèves à CMC ?", "CMC est équipée d'un large éventail de ressources technologiques adaptées à chaque spécialisation. Les élèves ont accès à des outils et logiciels modernes pour la programmation, les applications industrielles et la technologie agricole, favorisant la littératie numérique et les compétences pratiques nécessaires pour le marché du travail moderne."),
    listOf("Quel est le processus d'inscription à CMC ?", "Pour s'inscrire à CMC, les futurs élèves doivent compléter un processus d'inscription qui comprend le remplissage d'un formulaire de candidature et le paiement d'une frais d'inscription de 950 MAD. Cette somme garantit que les élèves ont accès à diverses ressources et installations, posant ainsi les bases de leur parcours éducatif."),
    listOf("Y a-t-il des frais ou des coûts de scolarité associés à CMC ?", "Oui, il y a des frais d'inscription de 950 MAD, qui couvrent les coûts administratifs et l'accès aux installations scolaires. Notamment, CMC fournit des repas gratuits à tous les élèves, réduisant ainsi le fardeau financier des familles et favorisant un environnement d'apprentissage sain."),
    listOf("Comment CMC communique-t-elle avec les parents au sujet des progrès des élèves ?", "(Si cette information n'est pas fournie, vous pourriez envisager d'inclure des méthodes comme des réunions régulières parents-enseignants, des bulletins de progrès ou un portail en ligne pour suivre la performance des élèves.)"),
    listOf("Quelles mesures de sécurité sont en place à CMC ?", "(Considérez le fait de détailler les protocoles de sécurité tels que les exercices d'urgence, le personnel de sécurité, les directives sanitaires ou les politiques pour maintenir un environnement d'apprentissage sûr.)"),
    listOf("Y a-t-il un programme de déjeuner à CMC et quelles sont les options alimentaires ?", "Oui, CMC propose un programme de déjeuner gratuit pour les élèves. Les repas sont nutritifs et tiennent compte de diverses préférences alimentaires, garantissant que les élèves reçoivent une nutrition équilibrée tout au long de la journée scolaire, ce qui est essentiel pour leur développement physique et cognitif."),
    listOf("Quels services de soutien sont disponibles pour les élèves à CMC (par exemple, conseils, tutorat) ?", "CMC offre des services de soutien étendus, y compris des conseils académiques, des programmes d'orientation pour aider les élèves à s'adapter à l'environnement scolaire, et l'accès à un psychiatre pour un soutien en santé mentale. Ces services sont conçus pour promouvoir le bien-être général et le succès académique."),
    listOf("Comment CMC prépare-t-elle les élèves à des parcours académiques ou professionnels futurs ?", "CMC prépare les élèves à leur future emploi grâce à un programme structuré qui inclut des stages et des expériences pratiques liées à leurs domaines d'études. Cette approche pratique améliore non seulement leurs compétences, mais leur offre également des perspectives inestimables sur le monde du travail, rendant les élèves plus compétitifs et prêts pour le marché du travail.")
)
@Composable
fun AllInfo(list: List<List<String>>, isScreen: MutableState<Boolean>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState() )) {
        Topbare(isScreen)
        for (i in list) {
            Info(qoution = i[0], anser = i[1])
        }
    }
}
@Composable
fun MyApp(){
    var isScreen = remember {
        mutableStateOf(true)
    }
    if(isScreen.value){
        Hello(isScreen)
    }else{
       AllInfo(list = infoList, isScreen =isScreen )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CmcInfoTheme {
        MyApp()
    }
}