# Lucid

Simplistic Minecraft Packet API for Spigot/Bukkit servers.
Uses a script to generate accessor classes for each packet type.
Based on the latest Minecraft Java version available right now (1.19.4)
Some legacy accessors might be missing.

# Setup

Create a new API instance with ```Lucid#create``` and start it up by calling ```Lucid#start```
Now you can listen to any ```PacketEvent``` using the Bukkit Listener API.
You can also send or receive your own packets by using the accessors in the `accessors` package.
Documentation is found throughout the code if extra details on implementation are needed.

# Note

This project is still under development, please be cautious that some accessor classes might be missing and bugs can be expected.
