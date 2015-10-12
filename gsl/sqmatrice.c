#include <stdio.h>
#include <gsl/gsl_matrix.h>
/*
in matlab or octave
orig = [2.580000 -3.100000 4.250000
> 3.821000 4.440000 5.656000
> 1.820000 7.410000 3.330000]
orig =

   2.5800  -3.1000   4.2500
   3.8210   4.4400   5.6560
   1.8200   7.4100   3.3300

octave:4> trans = orig'
trans =

   2.5800   3.8210   1.8200
  -3.1000   4.4400   7.4100
   4.2500   5.6560   3.3300
*/     
int main (void) {
       int i, j; 
       FILE *opointer;
       opointer = fopen("initial.txt","w");

       FILE *tpointer;
       tpointer = fopen("transpose.txt","w");
       char *ofmt;
       ofmt = "%f";
       printf("The output file format ofmt %s \n",ofmt);
       printf("will be used in gsl_matrix_fprintf (opointer, m, ofmt)\n");
       gsl_matrix * m = gsl_matrix_alloc (3, 3);
       gsl_matrix_set (m, 0, 0, 2.58);
       gsl_matrix_set (m, 0, 1, -3.1);
       gsl_matrix_set (m, 0, 2, 4.25);
       gsl_matrix_set (m, 1, 0, 3.821);
       gsl_matrix_set (m, 1, 1, 4.44);
       gsl_matrix_set (m, 1, 2, 5.656);
       gsl_matrix_set (m, 2, 0, 1.82);
       gsl_matrix_set (m, 2, 1, 7.41);
       gsl_matrix_set (m, 2, 2, 3.33);
/*
Function: int gsl_matrix_fprintf (FILE * stream, const gsl_matrix * m, const char * format)

    This function writes the elements of the matrix m line-by-line to the stream stream using the format specifier format, which should be one of the %g, %e or %f formats for floating point numbers and %d for integers. The function returns 0 for success and GSL_EFAILED if there was a problem writing to the file. 
*/
       gsl_matrix_fprintf (opointer, m, ofmt);
       printf ("Initial test matrice \n");
       for (i = 0; i < 3; i++) {
         for (j = 0; j < 3; j++) {
           printf ("m(%d,%d) = %g\n", i, j,
           gsl_matrix_get (m, i, j)); 
          }
        }
        printf ("transpose of initial matrice \n");
        printf ("the matrice needs to be square\n");
        printf ("%x\n",*m);
        printf ("sizeof of struct m %d  \n",sizeof(*m));
        printf("num of rows %d\n",m->size1);
        printf("num of cols %d\n",m->size2);
        if (m->size1 == m->size2) { 
          gsl_matrix_transpose (m);
        for (i = 0; i < 3; i++) {
         for (j = 0; j < 3; j++) {
           printf ("m(%d,%d) = %g\n", i, j,
           gsl_matrix_get (m, i, j)); 
          }
        }
        gsl_matrix_fprintf (tpointer, m, ofmt); 
        }
        else printf("the matrice is not square can not transpose\n");
        gsl_matrix_set_identity (m);
        printf ("The identity matrice \n");
       for (i = 0; i < 3; i++) {
         for (j = 0; j < 3; j++) {
           printf ("m(%d,%d) = %g\n", i, j,
           gsl_matrix_get (m, i, j)); 
          }
        }         
       gsl_matrix_free (m);
     
       return 0;
     }
