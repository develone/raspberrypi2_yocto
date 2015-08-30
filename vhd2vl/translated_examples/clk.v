// File ../examples/clk.vhd translated with vhd2vl v2.0 VHDL to Verilog RTL translator
// Copyright (C) 2001 Vincenzo Liguori - Ocean Logic Pty Ltd - http://www.ocean-logic.com
// Modifications (C) 2006 Mark Gonzales - PMC Sierra Inc
// 
// vhd2vl comes with ABSOLUTELY NO WARRANTY
// ALWAYS RUN A FORMAL VERIFICATION TOOL TO COMPARE VHDL INPUT TO VERILOG OUTPUT 
// 
// This is free software, and you are welcome to redistribute it under certain conditions.
// See the license file license.txt included with the source for details.


module clk(
reset,
preset,
qreset,
sysclk,
dsysclk,
esysclk,
ival
);

input reset, preset, qreset, sysclk, dsysclk, esysclk;
input[31:0] ival;

wire   reset;
wire   preset;
wire   qreset;
wire   sysclk;
wire   dsysclk;
wire   esysclk;
wire  [31:0] ival;


reg [10 + 3:0] foo;
reg [2:0] baz;
reg [4:7 - 1] egg;

  always @(posedge reset or posedge sysclk) begin
    if((reset != 1'b 0)) begin
      foo <= {(((10 + 3))-((0))+1){1'b1}};
    end else begin
      foo <= ival[31:31 - ((10 + 3))] ;
    end
  end

  always @(negedge preset or negedge dsysclk) begin
    if((preset != 1'b 1)) begin
      baz <= {3{1'b0}};
    end else begin
      baz <= ival[2:0] ;
    end
  end

  always @(negedge qreset or negedge esysclk) begin
    if((qreset != 1'b 1)) begin
      egg <= {(((7 - 1))-((4))+1){1'b0}};
    end else begin
      egg <= ival[6:4] ;
    end
  end


endmodule
