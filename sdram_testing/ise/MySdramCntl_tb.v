`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   07:30:15 10/09/2015
// Design Name:   MySdramCntl
// Module Name:   C:/Users/vidal/Documents/GitHub/SDRAM_Controller/SDRAM/MySdramCntl_tb.v
// Project Name:  SDRAM
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: MySdramCntl
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module MySdramCntl_tb;

	// Inputs
	reg clk_i;
	reg host_intf_wr_i;
	reg host_intf_rst_i;
	reg [15:0] host_intf_data_i;
	reg host_intf_rd_i;
	reg [23:0] host_intf_addr_i;

	// Outputs
	wire sd_intf_cke;
	wire sd_intf_we;
	wire [12:0] sd_intf_addr;
	wire sd_intf_dqml;
	wire sd_intf_cas;
	wire sd_intf_dqmh;
	wire sd_intf_ras;
	wire [1:0] sd_intf_bs;
	wire sd_intf_cs;
	wire host_intf_done_o;
	wire host_intf_rdPending_o;
	wire [15:0] host_intf_data_o;

	// Bidirs
	wire [15:0] sd_intf_dq;

	// Instantiate the Unit Under Test (UUT)
	MySdramCntl uut (
		.clk_i(clk_i), 
		.sd_intf_cke(sd_intf_cke), 
		.sd_intf_we(sd_intf_we), 
		.sd_intf_addr(sd_intf_addr), 
		.sd_intf_dqml(sd_intf_dqml), 
		.sd_intf_cas(sd_intf_cas), 
		.sd_intf_dqmh(sd_intf_dqmh), 
		.sd_intf_ras(sd_intf_ras), 
		.sd_intf_bs(sd_intf_bs), 
		.sd_intf_cs(sd_intf_cs), 
		.sd_intf_dq(sd_intf_dq), 
		.host_intf_wr_i(host_intf_wr_i), 
		.host_intf_done_o(host_intf_done_o), 
		.host_intf_rdPending_o(host_intf_rdPending_o), 
		.host_intf_rst_i(host_intf_rst_i), 
		.host_intf_data_i(host_intf_data_i), 
		.host_intf_data_o(host_intf_data_o), 
		.host_intf_rd_i(host_intf_rd_i), 
		.host_intf_addr_i(host_intf_addr_i)
	);

	initial begin
		// Initialize Inputs
		clk_i = 0;
		host_intf_wr_i = 0;
		host_intf_rst_i = 0;
		host_intf_data_i = 0;
		host_intf_rd_i = 0;
		host_intf_addr_i = 0;

		// Wait 100 ns for global reset to finish
		#100;
        
		// Add stimulus here

	end
      
endmodule

