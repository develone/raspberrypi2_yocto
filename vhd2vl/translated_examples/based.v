// File ../examples/based.vhd translated with vhd2vl v2.0 VHDL to Verilog RTL translator
// Copyright (C) 2001 Vincenzo Liguori - Ocean Logic Pty Ltd - http://www.ocean-logic.com
// Modifications (C) 2006 Mark Gonzales - PMC Sierra Inc
// 
// vhd2vl comes with ABSOLUTELY NO WARRANTY
// ALWAYS RUN A FORMAL VERIFICATION TOOL TO COMPARE VHDL INPUT TO VERILOG OUTPUT 
// 
// This is free software, and you are welcome to redistribute it under certain conditions.
// See the license file license.txt included with the source for details.


module based(
sysclk
);

input sysclk;

wire   sysclk;


wire  foo;
wire  foo2;
wire  foo8;
wire  foo10;
wire  foo11;
wire  foo16;

  assign foo = 123;
  assign foo2 = 'B00101101110111;
  assign foo8 = 'O0177362;
  assign foo10 = 'D01234;
  assign foo11 = 11#01234#;
  assign foo16 = 'H12af;

endmodule
