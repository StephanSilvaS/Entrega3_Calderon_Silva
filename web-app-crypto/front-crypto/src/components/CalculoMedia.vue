<template>
	<div>
		<h1>Valor de Bitcoin </h1>
		<input type="file" id="csv-file" />
		<button @click="uploadFile">Upload File</button>
		<table v-if="uploadFile" style="text-align: center; margin: 0 auto; border: 1px solid black;">
			<thead>
				<tr>
					<th>Dia</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="row in data" :key="row[0]">
					<td>{{ row[0] }}</td>
					<td>{{ row[1] }}</td>
				</tr>
			</tbody>
		</table>
	</div>
</template>
  
<script>
	import Papa from "papaparse";
  
	export default {
		name: 'CalculoMedia',
		props: {
		msg: String
		},

		data() {
		return {
			data: [],
			tableData: "",
		};
		},
		methods: {
		uploadFile() {
			const file = document.getElementById("csv-file").files[0];
			const reader = new FileReader();
			reader.onload = (event) => {
			const data = Papa.parse(event.target.result, {
				header: false,
			});
			this.data = data.data;
			};
			reader.readAsText(file);
		},
		mean(column) {
			const sum = column.reduce((a, b) => a + b, 0);
			return sum / column.length;
		},
		standardDeviation(row) {
			const mean = this.mean(row);
			const squaredDeviations = row.map((value) => Math.pow(value - mean, 2));
			const variance = squaredDeviations.reduce((a, b) => a + b, 0) / row.length;
			return Math.sqrt(variance);
		},
		},

		computed: {
			average() {
				if (this.data.length === 0) {
					return 0;
				} else {
					return this.data.reduce((acc, curr) => acc + curr, 0) / this.data.length;
				}
			},
		},
	};
</script>