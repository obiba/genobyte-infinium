# genobyte-infinium

## Quick Start Manual

GenoByte is a generic API for manipulating large collections of genotypes. Typically, GenoByte is used as the basis of a genotyping application. The package comes with an example of such an application: genobyte-infinium. This simple application can do some basic analysis on  high-throughput Infinium data.

This manual gives you instructions to install and run the genobyte-infinium. A detailed description of how the genobyte-infinium was built on top of the GenoByte will soon be available.

```
cd src/bin
./genobyte-infinium.sh
```

After either of these steps,  you should have a console open with the sign > as a prompt.

```
Type '-h' for help, '-q' to quit.
>
```

Create a datastore named mystore with the following command:

```
> --create mystore
Creating store mystore.
mystore_samples>
```

Your prompt should now be preceded with the name of the store and the word samples. Load some sample data from an Illumina Sample Sheet with the following command:

```
mystore_samples> --load samples data/samples.csv
Loading file [samples.csv]
Loading sample sheet [samples.csv]
Loaded 11 samples from sample sheet.
mystore_samples>
```

Load some assay data (SNPs) from an Illumina Manifest text file with the following command:

```
mystore_samples> --load assays data/manifest.csv
Loading file [manifest.csv]
Loading manifest [manifest.csv]
Loaded 1000 assays from manifest.
mystore_samples>
```

Load genotypes from an Illumina "Locus X DNA Report" with the following command:

```
mystore_samples> --load genotypes data/genotypes.csv
Loading file [genotypes.csv]
Loading LocusXDna report [genotypes.csv]
Processing sample 11/11
Loaded genotypes in XXX seconds
mystore_samples>
```

At this point, the samples' genotypes have been populated. To populate the assays' genotypes, the data needs to be "transposed" from the samples matrix to the assays matrix by using the following command:

```
mystore_samples> --transpose
Took X.XXXs
mystore_samples> 
```

All the data you need has now been loaded and prepared, you are ready to do some work.

You may now execute queries on the data and reference them later on to produce different reports or analysis. Select a subset of samples and store the result in "q1" the first query in your query stack:

```
mystore_samples> group:AFFECTED
q1: 6 results in XX milliseconds.
mystore_samples>
```

To select a subset of SNPs, you need to switch the to the assays store by executing the following command:

```
mystore_samples> --switch
mystore_assays>
```

Select a subset of the SNPs to include in your analysis/reports. If you skip this step, all loaded SNPs will be used.

```
mystore_assays> chromosome:chr1
q2: 90 results in XX milliseconds.
mystore_assays>
```

Generate a DNA report in a file called dna_report.csv with the following command:

```
mystore_assays> --report dna dna_report.csv
Producing report type [dna].
Calculating DNA report for 11 samples on 1000 assays.
Producing DNA report.
mystore_assays>
```

To generate the same kind of report, but on a subset of samples and assays, you must reference previously executed queries:

```
mystore_assays> --report dna dna_report.csv q1 q2
Producing report type [dna].
Calculating DNA report for 6 samples on 90 assays.
Producing DNA report.
mystore_assays>
```

Generate a locus report in a file called locus_report.csv with the following command:

```
mystore_assays> --report locus locus_report.csv q1 q2
Producing report type [locus].
Calculating locus report for 90 assays on 6 samples.
Producing locus report.
mystore_assays>
```

Generate a genotype report in a file called ped_file.txt with the following command:

```
Creating [pedfile] report on 6 samples and 90 assays. Outputing report to file(s) [mystore.ped]
mystore_assays> --genotypes pedfile mystore.ped q1 q2
mystore_assays>
```

Close the application with the following command:
```
mystore_assays> --quit
```
