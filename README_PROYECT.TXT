Universidad de Puerto Rico en Mayagüez 
		Proyecto Minecraft
		
Items/blocks implemented:
	Sand Brick 
	Sand Clay
	Tablet 
	Teleport Button
	Lasha Sand Block
	Sand Clay Block
	Teleport Block
	
Weapons/Armor implemented:
	Nova Sword 
	Nova Shovel 
	Nova Pick
	Nova Axe 
	Nova Hoe
	Fast Bow
	Nova Helmet 
	Nova Chestplate
	Nova Leggings 
	Nova Boots

Crafting recepies implemented:
	Lasha Sand Block 
	Tablet 
	Teleport Block
	Teleport Button 
	plese check json files in assets/pm/recipes for the recipe

Important Notes!
	-Sand Clay block only spawns on desert bioms
		Use this seed to spawn directly close to a desert biom 7890
		Sand Clay spawns the same layers as sand stone 
		Heres a coordinate to help you find one right when you spawn -254,69,-5		
		Dig a 4x4 block area to increase your chances to find it
		This block drops sand clay that smelts into sand brick
		
	-Teleport block uses iron, gold and diamonds
		iron = 10 usages
		gold = 40 usages
		diamond = 160 usages

		Teleporter usages will depend on the distance.

		If player sneaks and right clicks top part of block, ID will decrease.

		Sneak and right click side parts of the block increased ID.

		Teleporter works within a 64 block radius.

		In order to teleport from one teleporter to the other, you will need the teleporter button

		The teleporter block slot only accepts goodies, BUT if you want to burn the goodies to generate usages,
		then you will need to have the tablet, which was an implemented item from our mod. With the tablet,
		you're going to right click the teleporter block and this will generate a determined amount of usages
		depending on the item that was on the teleporter block slot. We did this on purpose, so the player will not
		be able to accidentally burn some of their goodies that they didn't want to if they accidentaly placed the ingot 
		on the slot. 

		If teleporter blocks were detected but solid block were placed in top of them, then the transportation will be denied.

		If there are no goodies in the teleporter block container, then the tablet will simply display the block information,
		such as the ID and the amount of usages that it currently has. 
		gold = 20 usages
		diamond = 40 usages
		Teleporter needs 100 usages
		If player sneaks and right clicks without holding an item at the top part of block, ID will decrease 
		Sneak and right click side parts of the block without holding an item increases the ID
		Teleporter works within a 64 block radius
		
	-Tablet shows the id of the teleporter and how many usages it has
		just right click at the block anywhere
		
	-Teleport Button is main function is to activate the teleporter
		right click anywhere on the block
	
	-To fly in survival you need to be holding a sand brick item and need 10 levels or more to fly		
	-You can change the fly keyboard in settings i the mod tabs at the end

	-The created armors and tools can be accesed via creative mode only