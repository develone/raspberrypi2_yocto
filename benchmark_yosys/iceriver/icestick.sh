 
yosys -p "synth_ice40 -blif ./iceriver/icestick.blif" ./iceriver/icestick.v
arachne-pnr -d 1k -p ./iceriver/icestick.pcf ./iceriver/icestick.blif -o ./iceriver/icestick.txt 
icepack ./iceriver/icestick.txt ./iceriver/icestick.bin 
