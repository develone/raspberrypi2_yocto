// File ../examples/ifchain.vhd translated with vhd2vl v2.0 VHDL to Verilog RTL translator
// Copyright (C) 2001 Vincenzo Liguori - Ocean Logic Pty Ltd - http://www.ocean-logic.com
// Modifications (C) 2006 Mark Gonzales - PMC Sierra Inc
// 
// vhd2vl comes with ABSOLUTELY NO WARRANTY
// ALWAYS RUN A FORMAL VERIFICATION TOOL TO COMPARE VHDL INPUT TO VERILOG OUTPUT 
// 
// This is free software, and you are welcome to redistribute it under certain conditions.
// See the license file license.txt included with the source for details.


module test(
clk,
rstn
);

input clk, rstn;

wire   clk;
wire   rstn;


wire [3:0] a;
wire [3:0] b;
reg  status;

  always @(posedge clk) begin
    if({b[1] ,a[3:2] } == 3'b 001) begin
      status <= 1'b 1;
    end
  end


endmodule
