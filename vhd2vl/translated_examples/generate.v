// File ../examples/generate.vhd translated with vhd2vl v2.0 VHDL to Verilog RTL translator
// Copyright (C) 2001 Vincenzo Liguori - Ocean Logic Pty Ltd - http://www.ocean-logic.com
// Modifications (C) 2006 Mark Gonzales - PMC Sierra Inc
// 
// vhd2vl comes with ABSOLUTELY NO WARRANTY
// ALWAYS RUN A FORMAL VERIFICATION TOOL TO COMPARE VHDL INPUT TO VERILOG OUTPUT 
// 
// This is free software, and you are welcome to redistribute it under certain conditions.
// See the license file license.txt included with the source for details.


module gen(
sysclk,
reset,
wrb,
din,
rdout
);

parameter bus_width=15;
parameter TOP_GP2=0;
input sysclk, reset, wrb;
input[bus_width:0] din;
output[bus_width:0] rdout;

wire   sysclk;
wire   reset;
wire   wrb;
wire  [bus_width:0] din;
wire  [bus_width:0] rdout;


reg [bus_width * 2:0] regSelect;

  //---------------------------------------------------
  // Reg    : GP 2
  // Active : 32
  // Type   : RW
  //---------------------------------------------------
  genvar bitnum;
  generate for (bitnum=0; bitnum <= bus_width; bitnum = bitnum + 1) begin
      wbit1 wbit1_inst(
          .clk(sysclk),
      .wrb(wrb),
      .reset(reset),
      .enb(regSelect[TOP_GP2] ),
      .din(din[bitnum] ),
      .dout(rdout[bitnum] ));

  end
  endgenerate
  always @(posedge sysclk) begin
    regSelect[1]  <= 1'b 1;
  end


endmodule
