import aiohttp
import asyncio
import discord 
from discord.ext import commands
import os 
from dotenv import load_dotenv
import logging

load_dotenv()
token = os.getenv('DISCORD_TOKEN', '')
handler = logging.FileHandler(filename='discord.log', encoding='utf-8', mode='w')

intents = discord.Intents.default()
intents.message_content = True
intents.members = True

bot = commands.Bot(command_prefix='!', intents=intents)

@bot.event
async def on_ready():
    print(f" Bot connecté en tant que {bot.user}")
    
    # Pour chaque serveur où le bot est déjà présent
    for guild in bot.guilds:
        print(f"Envoi du message d’accueil dans {guild.name}")
        await send_welcome_message(guild)


@bot.event
async def on_guild_join(guild):
    print(f" Nouveau serveur rejoint : {guild.name}")
    await send_welcome_message(guild)


async def send_welcome_message(guild):
    for channel in guild.text_channels:
        if channel.permissions_for(guild.me).send_messages:
            try:
                await channel.send(
                    f" Bonjour à tous sur **{guild.name}** ! Le bot est maintenant en ligne 🚀\n"
                    "Voici le format attendu pour soumettre un avis :\n"
                    "```\n"
                    "!avis Cours: IFT2255 | Difficulté: 7 | Charge: 6 | Commentaire: Projet intéressant mais long\n"
                    "```"
                )
            except Exception as e:
                print(f" Erreur d’envoi dans {channel.name}: {e}")




@bot.event
async def on_message(message : discord.Message):
   
    if message.author == bot.user:
        return
     
    if message.content.startswith("!avis"):
        content = message.content[len("!avis"):].strip()
        parts = [p.strip() for p in content.split("|")]

        if len(parts) != 4:
            await message.channel.send(" Format invalide ! Il faut 4 sections séparées par '|'.")
            return

        valid_labels = ["Cours:", "Difficulté:", "Charge:", "Commentaire:"]
        for part, expected in zip(parts, valid_labels):
            if not part.startswith(expected):
                await message.channel.send(f" La section '{expected}' est manquante ou mal placée.")
                return

        cours = parts[0].split(":", 1)[1].strip()
        difficulte = parts[1].split(":", 1)[1].strip()
        charge = parts[2].split(":", 1)[1].strip()
        commentaire = parts[3].split(":", 1)[1].strip()

       
        payload = {
            "cours": cours,
            "difficulte": difficulte,
            "charge": charge,
            "commentaire": commentaire,
            "auteur": str(message.author)
        }
        async with aiohttp.ClientSession() as session:
            async with session.post("http://localhost:7070/api/avis", json=payload) as response:

            
                if response.status == 201:
                    await message.channel.send(" Avis reçu et enregistré avec succès !")
                else:
                    txt = await response.text()
                    await message.channel.send(f" Erreur lors de l’envoi ({response.status}): {txt}")


 
    await bot.process_commands(message)
 
bot.run(token , log_handler= handler , log_level= logging.DEBUG )