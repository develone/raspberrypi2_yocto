// File ../examples/expr.vhd translated with vhd2vl v2.0 VHDL to Verilog RTL translator
// Copyright (C) 2001 Vincenzo Liguori - Ocean Logic Pty Ltd - http://www.ocean-logic.com
// Modifications (C) 2006 Mark Gonzales - PMC Sierra Inc
// 
// vhd2vl comes with ABSOLUTELY NO WARRANTY
// ALWAYS RUN A FORMAL VERIFICATION TOOL TO COMPARE VHDL INPUT TO VERILOG OUTPUT 
// 
// This is free software, and you are welcome to redistribute it under certain conditions.
// See the license file license.txt included with the source for details.


module expr(
reset,
sysclk,
ival
);

input reset, sysclk, ival;

wire   reset;
wire   sysclk;
wire   ival;


reg [13:0] foo;
wire [2:0] baz;
reg [22:0] bam;
wire [5:3] out_i;
wire  enable;
wire  debug;
wire  aux;
wire  outy;
wire  dv;
wire  value;

  // drive input status
  assign input_status = {foo[9:4] ,((baz[3:0]  & foo[3:0]  | (( ~baz[3:0]  & bam[3:0] ))))};
  // drive based on foo
  assign out_i = ((enable & ((aux ^ outy)))) | ((debug & dv &  ~enable)) | (( ~debug &  ~enable & value));
  // not drive
  always @(negedge reset or negedge sysclk) begin
    if((reset != 1'b 0)) begin
      foo <= {14{1'b0}};
    end else begin
      foo[3 * ((2 - 1))]  <= (4 * ((1 + 2)));
      bam[13:0]  <= foo;
    end
  end


endmodule
